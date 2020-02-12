SELECT NOTI_INDEX, NOTI_TITLE, NOTI_CONTENT, NOTI_CATAGORY, 
NOTI_WRITER, NOTI_WDATE, FILENAME, TEMPFILE, READCOUNT, NOTI_DEL 
FROM (select ROWNUM AS RNUM, NOTI_INDEX, NOTI_TITLE, NOTI_CONTENT, NOTI_CATAGORY, 
			NOTI_WRITER, NOTI_WDATE, FILENAME, TEMPFILE, READCOUNT, NOTI_DEL 
			FROM (SELECT * FROM NOTICEBBS 
			WHERE NOTI_DEL = 0
			--AND NOTI_TITLE LIKE '%TEST%'
			ORDER BY NOTI_WDATE desc)
	)
WHERE RNUM >= 1 AND RNUM <= 10