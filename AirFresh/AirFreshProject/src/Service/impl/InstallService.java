package Service.impl;

import java.io.Serializable;
import java.util.List;

import Dao.InstallDaoInterface;
import Dao.impl.InstallDao;
import Dto.InstallDto;
import Service.InstallServiceInterface;

public class InstallService implements InstallServiceInterface,Serializable {
	
	
	//서비스의 싱글톤화   private static InstallServiceInterface installService = null;
	 
	private InstallDaoInterface dao = new InstallDao();
	
	public InstallService() {
	}
	/*
	public static InstallServiceInterface getInstance() {
		if(installService == null) {
			installService = new InstallService();
		}
		return installService;
	}
	*/
	public List<InstallDto> getNullInstallList(){
		
		return dao.getNullInstallList();
		
	}
	
	public List<InstallDto> getNullInstallList(String date){
		return dao.getNullInstallList(date);
	}
	
	
	public boolean addInstall(InstallDto dto) {
		
		return dao.addInstall(dto);
	}
	
	public boolean insertMgrID(int ins_index, int mgr_index) {
		return dao.insertMgrID(ins_index, mgr_index);
	}
	
	public boolean insertNull(int ins_index, int mgr_index) {
		return dao.insertNull(ins_index, mgr_index);
	}
	
	//로그인한 직원의 근무지에 해당되고 & 선택한 특정날짜의 Null 설치 리스트를 가져오는 메소드  
	public List<InstallDto> getMgrPicDayList(String date, String loc){
		return dao.getMgrPicDayList(date, loc);
	}
	
	//강남구, 성동구, 중랑구를 제외한 나머지 지역들의 Null 설치 리스트를 가져오는 메소드 
	public List<InstallDto> getGitaNullList(String date){
		return dao.getGitaNullList(date);
	}
}
