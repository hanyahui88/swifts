package com.swifts.frame.test;

import com.swifts.frame.common.utils.JedisUtils;
import com.swifts.frame.modules.sys.entity.Office;
import com.swifts.frame.modules.sys.service.OfficeService;
import com.swifts.frame.modules.test.dao.TestDao;
import com.swifts.frame.modules.test.entity.TestData;
import com.swifts.frame.modules.test.service.TestDataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yahui on 2016/1/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-context.xml","/spring-context-jedis.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
public class TestRedisCache {
    @Autowired
    private OfficeService officeService;
    @Autowired
    private TestDataService testDataService;
    @Test
    public void test(){
        Office office=new Office();
        office.setId("1");
        Office officeList=officeService.findListIntoCache(office);
        Office officeList1=officeService.findListIntoCache(office);
        System.out.print(officeList);
    }
    @Test
    public void test1(){
        TestData testData=new TestData();
        testDataService.findList(testData);
        String s=JedisUtils.get(TestDataService.class.toString());
        Object o=JedisUtils.toObject(s.getBytes());
    }
}
