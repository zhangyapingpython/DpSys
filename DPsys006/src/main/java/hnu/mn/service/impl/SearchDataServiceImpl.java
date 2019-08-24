package hnu.mn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.SearchDataMapper;
import hnu.mn.pojo.DataInfo;
import hnu.mn.service.SearchDataService;
@Service
public class SearchDataServiceImpl implements SearchDataService {
	@Resource
	SearchDataMapper searchDataMapper;

	//下面两个方法分别查计数和平均值
	@Override
	public String searchDataCountService(DataInfo dataInfo) {
	
		return searchDataMapper.selCountByFormSearch(dataInfo);
	}

	@Override
	public String serachDataAvgService(DataInfo dataInfo) {
		
		return searchDataMapper.selAvgByFormSearch(dataInfo);
	}

}
