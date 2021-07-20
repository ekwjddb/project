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
		String batchResult="성공";
		try {
			//사용자 정보 조회
			List<DelMemberVO> delmemberList = delmemberDAO.selectRetireMember();
			// 회원탈퇴가 된 사용자 정보가 존재하지 않는 경우 4번을 진행하고 존재하는 경우 3번 작업을 진행
			if(delmemberList != null) {
				for(int i = 0 ; i < delmemberList.size(); i++) {
					DelMemberVO delmemberVO = delmemberList.get(i);
					
					//해당 사용자 정보 삭제
					delmemberDAO.deleteRetireMember(delmemberVO);
				}
			}
		}catch(Exception e) {
			batchResult = "실패";
		}
		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		//logger.info("스케쥴 실행 : ["+ batchResult +"] "+ dateFormat.format(calendar.getTime()))
	}


}
