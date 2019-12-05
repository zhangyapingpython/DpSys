package hnu.mn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hnu.mn.mapper.AASqlMapper;
import hnu.mn.service.AASqlService;
@Service
public class AASqlServiceImpl implements AASqlService {
	@Resource
	AASqlMapper aASqlMapper;
	
	
	@Override
	public Object querySql(String SQL) {
		Object object=new Object();
		try {
			object = aASqlMapper.selBySql(SQL);
		} catch (Exception e) {
			System.out.println("查询出错");
		}		
		return object;
	}

}
