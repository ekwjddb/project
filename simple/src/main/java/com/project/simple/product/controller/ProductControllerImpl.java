package com.project.simple.product.controller;

import java.io.File;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.project.simple.member.vo.MemberVO;
import com.project.simple.product.service.ProductService;
import com.project.simple.product.vo.ProductVO;

@Controller("productController")

public class ProductControllerImpl implements ProductController{
	private static final String ARTICLE_IMAGE_REPO = "C:\\spring\\product_image";
	@Autowired
	private ProductService productService;
	@Autowired
	private ProductVO productVO;
	private static final Logger logger = LoggerFactory.getLogger(ProductControllerImpl.class);

	



	@Override //��ǰ����ϱ�
	@RequestMapping(value="product/addProduct.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity addProduct(MultipartHttpServletRequest multipartRequest, HttpServletResponse response)throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> productMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while (enu.hasMoreElements()) {
			String name = (String) enu.nextElement();
			String value = multipartRequest.getParameter(name);
			productMap.put(name, value);
			System.out.println(name);

		}

		String productImage = upload(multipartRequest);
		//HttpSession session = multipartRequest.getSession();
		//MemberVO memberVO = (MemberVO) session.getAttribute("member");
		//String memId = memberVO.getmemId();
		
		//inquiryMap.put("memId", memId);
		productMap.put("productImage", productImage);
		String productNum = (String) productMap.get("productNum");
		
		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			productService.addProduct(productMap);
			if (productImage != null && productImage.length() != 0) {
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + productImage);
				File destDir = new File(ARTICLE_IMAGE_REPO + "\\" + productNum);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
			}

			message = "<script>";
			message += " alert('��ǰ ����� �Ϸ�Ǿ����ϴ�.');";
			message += "  location.href='" + multipartRequest.getContextPath() + "/product/admin_listProduct.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);

		} catch (Exception e) {
			File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + productImage);
			srcFile.delete();

			message = "<script>";
			message += " alert('������ �߻��߽��ϴ�. �ٽ� �õ����ּ���');";
			message += "  location.href='" + multipartRequest.getContextPath() + "/product/add_product.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
		}
		return resEnt;
	}
	private String upload(MultipartHttpServletRequest multipartRequest) throws Exception {
		String productImage = null;
		Iterator<String> fileNames = multipartRequest.getFileNames();
		while (fileNames.hasNext()) {
			String fileName = fileNames.next();
			MultipartFile mFile = multipartRequest.getFile(fileName);
			productImage = mFile.getOriginalFilename();
			File file = new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + fileName);
			if (mFile.getSize() != 0) {
				if (!file.exists()) {
					file.getParentFile().mkdirs();
					mFile.transferTo(new File(ARTICLE_IMAGE_REPO + "\\" + "temp" + "\\" + productImage));// �ӽ÷� ����� multipartFile�� ���� ���Ϸ� ����
																							
				}
					
				
			}
		}
		return productImage;

	}
	//��ǰ�߰���
	@RequestMapping(value = "product/add_product.do", method = RequestMethod.GET)
	private ModelAndView add_product(HttpServletRequest request, HttpServletResponse response)  {
		String viewName = (String)request.getAttribute("viewName");
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		return mav;
	}
	

	@Override //��ǰ��� ��ȸ
	@RequestMapping(value="product/listProduct.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List<ProductVO> productList = productService.listProduct();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productList", productList);
		return mav;
	}
	
	@Override //������ ��ǰ��� ��ȸ
	@RequestMapping(value="product/admin_listProduct.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView admin_listProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		List<ProductVO> admin_productList = productService.admin_listProduct();
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("admin_productList", admin_productList);
		return mav;
	}
	
	//����ȭ��
	@RequestMapping(value = "/product/modProduct.do", method = {RequestMethod.GET, RequestMethod.POST})
	public ModelAndView productForm(@RequestParam("productNum") String productNum,
			MultipartHttpServletRequest multipartRequest, HttpServletResponse response) throws Exception {
			System.out.println(productNum);
			String viewName = (String) multipartRequest.getAttribute("viewName");
			productVO = productService.productForm(productNum);
			ModelAndView mav = new ModelAndView();
			mav.setViewName(viewName);
			mav.addObject("productNum", productVO);
			System.out.println(productVO);
			return mav;
		}
	@RequestMapping(value="/product/modNewProduct.do",method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public ResponseEntity modProduct(MultipartHttpServletRequest multipartRequest,
			HttpServletResponse response)throws Exception{
		multipartRequest.setCharacterEncoding("utf-8");
		Map<String, Object> productMap = new HashMap<String, Object>();
		Enumeration enu = multipartRequest.getParameterNames();
		while(enu.hasMoreElements()) {
			String name=(String)enu.nextElement();
			String value=multipartRequest.getParameter(name);
			productMap.put(name, value);
		
		}
		String productImage = upload(multipartRequest);
		productMap.put("productImage", productImage);
	
		
		String productNum = (String)productMap.get("productNum");
		productMap.put("productNum", productNum);


		String message;
		ResponseEntity resEnt = null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {		
			System.out.println(productMap);
			productService.modProduct(productMap);
		
			if(productImage!= null && productImage.length()!=0) {
				String OrignProductImage = (String)productMap.get("OrignProductImage");
				System.out.println(OrignProductImage);
				File oldFile = new File(ARTICLE_IMAGE_REPO+ "\\"+ productNum+"\\"+OrignProductImage);
				oldFile.delete();
				
				File srcFile = new File(ARTICLE_IMAGE_REPO + "\\" +"temp"+"\\"+productImage);
				File destDir = new File(ARTICLE_IMAGE_REPO+"\\"+productNum);
				FileUtils.moveFileToDirectory(srcFile, destDir, true);
				
				
			}
			message ="<script>";
			message += "alert('��ǰ�� �����߽��ϴ�.');";
			message += "location.href='"+multipartRequest.getContextPath()+"/product/admin_detailproduct.do?productNum="+ productNum + "';";
			message += "</script>";
			resEnt = new ResponseEntity(message, responseHeaders,HttpStatus.CREATED);
			} catch (Exception e) {
				File srcFile = new File(ARTICLE_IMAGE_REPO +"\\"+"temp"+"\\"+productImage);
				srcFile.delete();
				message ="<script>";
				message += "alert('������ �߻��߽��ϴ�. �ٽ� �������ּ���');";
				message += "location.href='"+multipartRequest.getContextPath()+"/product/admin_detailproduct.do?productNum="+productNum+"';";
				message += "</script>";
				resEnt = new ResponseEntity(message, responseHeaders,HttpStatus.CREATED);
			}
		return resEnt;
		}
	
	@Override
	@RequestMapping(value="/product/removeProduct.do", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity removeProduct(@RequestParam("productNum") String productNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("text/html; charset=UTF-8");
		String message;
		ResponseEntity resEnt=null;
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "text/html; charset=utf-8");
		try {
			productService.removeProduct(productNum);
			File destDir = new File(ARTICLE_IMAGE_REPO+"\\" + productNum);
			FileUtils.deleteDirectory(destDir);
			
			message = "<script>";
			message+= " alert('��ǰ�� �����߽��ϴ�.');";
			message += "  location.href='" + request.getContextPath() + "/product/admin_listProduct.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);	
			
		}catch(Exception e) {
				
			message = "<script>";
			message+= " alert('������ �߻��߽��ϴ�. �ٽ� �õ����ּ���');";
			message += "  location.href='" + request.getContextPath() + "/product/admin_listProduct.do';";
			message += " </script>";
			resEnt = new ResponseEntity(message, responseHeaders, HttpStatus.CREATED);
			e.printStackTrace();
			}
		return resEnt;
	}


	@RequestMapping(value="/product/viewProduct.do", method=RequestMethod.GET)
	public ModelAndView viewProduct(@RequestParam("productNum") String productNum, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		productVO = productService.viewProduct(productNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("product", productVO);
		System.out.println(productVO);
		return mav;
		
	}
	
	@RequestMapping(value="product/admin_detailproduct.do", method = RequestMethod.GET)
	public ModelAndView admin_detailproduct(@RequestParam("productNum") String productNum, HttpServletRequest request, HttpServletResponse response) throws Exception {
		String viewName = (String)request.getAttribute("viewName");
		productVO = productService.viewProduct(productNum);
		ModelAndView mav = new ModelAndView();
		mav.setViewName(viewName);
		mav.addObject("product", productVO);
		System.out.println(productVO);
		return mav;
	}
	
	//Ű���� �˻�
	@RequestMapping(value="/keywordSearch.do",method = RequestMethod.GET,produces = "application/text; charset=utf8")//�������� �����ϴ� json�������� �ѱ� ���ڵ��� ����
	public @ResponseBody String  keywordSearch(@RequestParam("keyword") String keyword,//�˻��� Ű���� ������
			                                  HttpServletRequest request, HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		//System.out.println(keyword);
		if(keyword == null || keyword.equals(""))
		   return null ;
	
		keyword = keyword.toUpperCase();
	    List<String> keywordList =productService.keywordSearch(keyword);// ������ Ű���尡 ���Ե� ��ǰ ���� ��ȸ
	    
	    // ���� �ϼ��� JSONObject ����(��ü)
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("keyword", keywordList); //��ȸ�� �����͸� json�� ����
		 		
	    String jsonInfo = jsonObject.toString(); //json�� ���ڿ��� ��ȯ�� �� �������� ���
	    //System.out.println(jsonInfo);
	    return jsonInfo ;
	}
	
	@RequestMapping(value="/searchProduct.do" ,method = RequestMethod.GET)
	public ModelAndView searchProduct(@RequestParam("searchWord") String searchWord,
			                       HttpServletRequest request, HttpServletResponse response) throws Exception{
		String viewName=(String)request.getAttribute("viewName");
		List<ProductVO> productList=productService.searchProduct(searchWord); // �˻�â���� ������ �ܾ ���Ե� ��ǰ ������ ��ȸ
		
		ModelAndView mav = new ModelAndView(viewName);
		mav.addObject("productList", productList);
		return mav;
		
	}

	
	

}