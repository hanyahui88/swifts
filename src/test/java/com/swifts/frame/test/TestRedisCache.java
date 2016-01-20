package com.swifts.frame.test;

import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.common.pagehelper.PageInfo;
import com.swifts.frame.modules.sys.entity.Office;
import com.swifts.frame.modules.sys.service.OfficeService;
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
//    @Autowired
//    private TestDataService testDataService;
    @Test
    public void test(){
        Office office=new Office();
        office.setId("1");
        PageInfo<Office> officeList2=officeService.findPage(1,3);
        System.out.print(officeList2);
    }
//    @Test
//    public void test1(){
//        TestData testData=new TestData();
//        testDataService.findList(testData);
//        String s=JedisUtils.get(TestDataService.class.toString());
//        Object o=JedisUtils.toObject(s.getBytes());
//    }
}
