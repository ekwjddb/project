package com.project.simple.delmember.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.project.simple.delmember.dao.DelMemberDAO;
import com.project.simple.delmember.vo.DelMemberVO;

public class RetireProcBatchRunner {
	
	@Autowired
	private DelMemberDAO delmemberDAO;
	
	@Scheduled(cron="0 0 1 * * ?")
	public void scheduleRun() {
		String batchResult="����";
		try {
			//����� ���� ��ȸ
			List<DelMemberVO> delmemberList = delmemberDAO.selectRetireMember();
			// ȸ��Ż�� �� ����� ������ �������� �ʴ� ��� 4���� �����ϰ� �����ϴ� ��� 3�� �۾��� ����
			if(delmemberList != null) {
				for(int i = 0 ; i < delmemberList.size(); i++) {
					DelMemberVO delmemberVO = delmemberList.get(i);
					
					//�ش� ����� ���� ����
					delmemberDAO.deleteRetireMember(delmemberVO);
				}
			}
		}catch(Exception e) {
			batchResult = "����";
		}
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//logger.info("������ ���� : ["+ batchResult +"] "+ dateFormat.format(calendar.getTime()))
	}


}
