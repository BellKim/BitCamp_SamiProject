package Dao;

import java.util.List;

import Dto.NoticeBbsDto;

public interface NoticeBbsDaoInterface {
	public List<NoticeBbsDto> getNoticeList();
	public List<NoticeBbsDto> getNoticeList(String opt, String keyword);
	public boolean writeNotice(NoticeBbsDto notice);
	public NoticeBbsDto getNoticeBbs(int noti_index);
	public void readcount(int noti_index);
}
