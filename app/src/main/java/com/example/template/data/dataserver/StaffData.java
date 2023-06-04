package com.example.template.data.dataserver;

import com.example.template.data.bean.Staff;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import cn.hutool.core.date.DateUtil;

public class StaffData {

    public static List<Staff> getStaffList() {
        List<Staff> staffList = new ArrayList<>();
        Staff staff1 = new Staff(1, "张三", "男", DateUtil.parse("1996-06-22"), "110101199001010001", "13800000001",
                "zhangsan@example.com", "北京市海淀区", "技术部", "软件工程师", "1001",
                new Date(2020, 1, 1), null, true, "北京市海淀区", 40,
                8000.0, 10, "良好", "李四", "13800000002", null, "https://www.bing.com/th?id=OHR.SnowdoniaNational_ZH-CN7415540950_1920x1080.jpg");
        Staff staff2 = new Staff(2, "李四", "女", DateUtil.parse("1996-06-22"), "110101199001010002", "13800000003",
                "lisi@example.com", "北京市朝阳区", "人事部", "人力资源专员", "1002",
                new Date(2019, 1, 1), null, true, "北京市朝阳区", 40,
                6000.0, 15, "良好", "王五", "13800000004", null, "https://www.bing.com/th?id=OHR.EuropeFromISS_ZH-CN0722816540_1920x1080.jpg");
        Staff staff3 = new Staff(3, "王五", "男", null, "110101199001010003", "13800000005",
                "wangwu@example.com", "北京市东城区", "财务部", "会计师", "1003",
                new Date(2018, 1, 1), null, true, "北京市东城区", 40,
                10000.0, 20, "良好", null, null, null, "");
        Staff staff4 = new Staff(4, "赵六", "女", null, "110101199001010004", "13800000006",
                "zhaoliu@example.com", "北京市西城区", "销售部", "销售经理", "1004",
                new Date(2017, 1, 1), null, true, "北京市西城区", 40,
                12000.0, 15, null, null, null, null, "");
        Staff staff5 = new Staff(5, "孙七", "男", null, "110101199001010005", "13800000007",
                null, null, null,"总经理助理","1005",
                new Date(2016, 5, 21),null,true,null,
                40,
                15000.0,8,null,null,null, null, "");
        Staff staff6 = new Staff(6,"周八","女" ,null,"110101199001010006","13800000008",
                null,null,"技术部","技术总监","1006",
                new Date(2015-1900+1-1-1),null,true,"北京市海淀区",
                40,
                20000.0,10,"良好","吴九","13800000009","拥有多年技术管理经验", "");
        Staff staff7 = new Staff(7, "郑十","男" ,null,"110101199001010007","13800000010",
                null,null,"人事部","人力资源总监","1007",
                new Date(2014-1900+1-1-1),null,true,"北京市朝阳区",
                40,
                25000.0,10,"良好","钱十一","13800000011","拥有多年人力资源管理经验", "");
        Staff staff8 = new Staff(8, "孔十二","女" ,null,"110101199001010008","13800000012",
                null,null,"财务部","财务总监","1008",
                new Date(2013-1900+1-1-1),null,true,"北京市东城区",
                40,
                30000.0,10,"良好","吕十三","13800000013","拥有多年财务管理经验", "https://www.bing.com/th?id=OHR.SnowdoniaNational_ZH-CN7415540950_1920x1080.jpg");
        Staff staff9 = new Staff(9, "王三十","女" ,null,"110101199001010024","13800000029",
                null,null,"人事部","人力资源总监","1023",
                new Date(1999-1900+1-1-1),null,true,"北京市朝阳区",
                40,
                100000.0,10,"良好",null,null,null, "");
        Staff staff10 = new Staff(10, "刘十五","女" ,null,"110101199001010010","13800000014",
                null,null,"销售部","销售总监","1009",
                new Date(2012-1900+1-1-1),null,true,"北京市西城区",
                40,
                35000.0,10,"良好","陈十六","13800000015","拥有多年销售管理经验", "");
        Staff staff11 = new Staff(11, "黄十七","男" ,null,"110101199001010011","13800000016",
                null,null,"技术部","技术总监","1010",
                new Date(2011-1900+1-1-1),null,true,"北京市海淀区",
                40,
                40000.0,10,"良好",null,null,null, "");
        Staff staff12 = new Staff(12, "徐十八","女" ,null,"110101199001010012","13800000017",
                null,null,"人事部","人力资源总监","1011",
                new Date(2010-1900+1-1-1),null,true,"北京市朝阳区",
                40,
                45000.0,10,"良好",null,null,null, "");
        Staff staff13 = new Staff(13, "胡十九","男" ,null,"110101199001010013","13800000018",
                null,null,"财务部","财务总监","1012",
                new Date(2009-1900+1-1-1),null,true,"北京市东城区",
                40,
                50000.0,10,"良好",null,null,null, "");
        Staff staff14 = new Staff(14, "朱二十","女" ,null,"110101199001010014","13800000019",
                null,null,"销售部","销售总监","1013",
                new Date(2008-1900+1-1-1),null,true,"北京市西城区",
                40,
                55000.0,10,"良好",null,null,null, "");
        Staff staff15 = new Staff(15, "杨二十一","男" ,null,"110101199001010015","13800000020",
                null,null,"技术部","技术总监","1014",
                new Date(2007-1900+1-1-1),null,true,"北京市海淀区",
                40,
                60000.0,10,"良好",null,null,null, "");
        Staff staff16 = new Staff(16, "吴二十二","女" ,null,"110101199001010016","13800000021",
                null,null,"人事部","人力资源总监","1015",
                new Date(2006-1900+1-1-1),null,true,"北京市朝阳区",
                40,
                65000.0,10,"良好",null,null,null, "");
        Staff staff17 = new Staff(17, "郭二十三","男" ,null,"110101199001010017","13800000022",
                null,null,"财务部","财务总监","1016",
                new Date(2005-1900+1-1-1),null,true,"北京市东城区",
                40,
                70000.0,15,"良好",null,null,null, "");
        Staff staff18 = new Staff(18, "陈二十四","女" ,null,"110101199001010018","13800000023",
                null,null,"销售部","销售总监","1017",
                new Date(2004-1900+1-1-1),null,true,"北京市西城区",
                40,
                75000.0,15,"良好",null,null,null, "");
        Staff staff19 = new Staff(19, "何二十六","女" ,null,"110101199001010020","13800000025",
                null,null,"人事部","人力资源总监","1019",
                new Date(2003-1900+1-1-1),null,true,"北京市朝阳区",
                40,
                80000.0,15,"良好",null,null,null, "");
        Staff staff20 = new Staff(20, "林二十七","男" ,null,"110101199001010021","13800000026",
                null,null,"财务部","财务总监","1020",
                new Date(2002-1900+1-1-1),null,true,"北京市东城区",
                40,
                85000.0,15,"良好",null,null,null, "");
        Staff staff21 = new Staff(21, "张二十八","女" ,null,"110101199001010022","13800000027",
                null,null,"销售部","销售总监","1021",
                new Date(2001-1900+1-1-1),null,true,"北京市西城区",
                40,
                90000.0,15,"良好",null,null,null, "");
        Staff staff22 = new Staff(22, "李二十九","男" ,null,"110101199001010023","13800000028",
                null,null,"技术部","技术总监","1022",
                new Date(2000-1900+1-1-1),null,true,"北京市海淀区",
                40,
                95000.0,15,"良好",null,null,null, "https://www.bing.com/th?id=OHR.EuropeFromISS_ZH-CN0722816540_1920x1080.jpg");

//        staffList.add(staff1);
        staffList.add(staff2);
        staffList.add(staff3);
        staffList.add(staff4);
        staffList.add(staff5);
        staffList.add(staff6);
        staffList.add(staff7);
        staffList.add(staff7);
        staffList.add(staff7);
        staffList.add(staff8);
//        staffList.add(staff9);
//        staffList.add(staff10);
//        staffList.add(staff11);
//        staffList.add(staff12);
//        staffList.add(staff13);
//        staffList.add(staff14);
//        staffList.add(staff15);
//        staffList.add(staff16);
//        staffList.add(staff17);
//        staffList.add(staff18);
//        staffList.add(staff19);
//        staffList.add(staff20);
//        staffList.add(staff21);
//        staffList.add(staff22);

        return staffList;
    }
}
