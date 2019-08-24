package hnu.mn.service;

import hnu.mn.pojo.DataInfo;

public interface SearchDataService {
	String searchDataCountService(DataInfo dataInfo);
	
	String serachDataAvgService(DataInfo dataInfo);
}
