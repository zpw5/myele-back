package com.xd.pre.modules.myeletric.mydb;

import com.xd.pre.modules.myeletric.domain.MyArea;
import com.xd.pre.modules.myeletric.domain.MyCommandInfo;
import com.xd.pre.modules.myeletric.domain.MyMeter;
import com.xd.pre.modules.myeletric.domain.MyRoom;
import com.xd.pre.modules.myeletric.mapper.MyCommandInfoMapper;
import com.xd.pre.modules.myeletric.service.IMyAreaService;
import com.xd.pre.modules.myeletric.service.IMyMeterService;
import com.xd.pre.modules.myeletric.service.IMyRoomService;
import com.xd.pre.modules.myeletric.service.impl.MyMeterServiceImpl;
import com.xd.pre.modules.pay.PaymentInfo;
import com.xd.pre.modules.pay.mapper.MyPaymentMapper;
import com.xd.pre.modules.sys.domain.SysUser;
import com.xd.pre.modules.sys.domain.SysUserCount;
import com.xd.pre.modules.sys.mapper.SysUserCountMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MyDbStub {

    @Autowired
    private IMyMeterService iMyMeterService;               //电表

    @Autowired
    private MyCommandInfoMapper myCommandInfoMapper;        //命令

    @Autowired
    private IMyAreaService iMyAreaService;

    @Autowired
    private IMyRoomService iMyRoomService;

    @Autowired
    private SysUserCountMapper sysUserCountMapper;    //业主账户管理

    @Autowired
    private MyPaymentMapper ipaymentMapper ;     //支付对象

    //单件对象
    public static MyDbStub sinTon = null;

    //获取单件对象
    public static MyDbStub getInstance()
    {
        if (null == sinTon)
        {
            sinTon = new MyDbStub();
        }

        return sinTon;
    }

    //设置Mapper
    public void setMapper(MyCommandInfoMapper devicecommandMapper,
                          IMyMeterService myMeterService ,
                          IMyAreaService areaService,
                          IMyRoomService roomService,
                          SysUserCountMapper userCountMapper,
                          MyPaymentMapper paymentMapper)
    {

        myCommandInfoMapper = devicecommandMapper;
        iMyMeterService = myMeterService;
        iMyAreaService =  areaService;
        iMyRoomService = roomService;
        sysUserCountMapper = userCountMapper;
        ipaymentMapper = paymentMapper;
    }

    //保存命令对象
    public Integer saveDeviceCommandDB(MyCommandInfo commandInfo)
    {
        if (null == myCommandInfoMapper)
        {
            return 0;
        }

        return myCommandInfoMapper.saveCommandInfo(commandInfo);
    }

    //更新命令对象
    public  Integer uptDeviceCommand(MyCommandInfo commandInfo)
    {
        if (null == myCommandInfoMapper || commandInfo == null)
        {
            return 0;
        }

        return myCommandInfoMapper.updateCommandResult(commandInfo);
    }

    //提取最大命令号
    public  Integer getMaxCommandSN()
    {
        if (null == myCommandInfoMapper)
        {
            return 0;
        }
        try
        {
            return  myCommandInfoMapper.getMaxCommandSN();
        }
        catch (Exception ex)
        {
            return 0;
        }
    }

    /****************************************************************************************************************************************
     *              电表管理
     *
     **********************************************************************************************************/
    public MyMeter getMeter(int nMeterID)
    {
        List<MyMeter> lstMeter = iMyMeterService.getMeter(nMeterID);
        if (null == lstMeter || lstMeter.size() == 0)
        {
            return null;
        }
        return lstMeter.get(0);
    }


    /****************************************************************************************************************************************
     *              园区管理
     *
     **********************************************************************************************************/
    public MyArea getArea(int nAreaID)
    {
        return iMyAreaService.getAreaByID(nAreaID);
    }

    /****************************************************************************************************************************************
     *              园房间管理
     *
     **********************************************************************************************************/
    public MyRoom getRoom(int nRoomID)
    {
        return iMyRoomService.getRoomByID(nRoomID);
    }

    /****************************************************************************************************************************************
     *              支付单
     *
     **********************************************************************************************************/
    public Integer SavePayment(PaymentInfo paymentInfo)
    {
        return ipaymentMapper.createNewPayment(paymentInfo);
    }

    /****************************************************************************************************************************************
     *              业主账号
     *
     **********************************************************************************************************/
    public SysUserCount GetUserCount(int nUserID)
    {
        List<SysUserCount> lstUserCount = sysUserCountMapper.getUserCountByUserID(nUserID);
        if (null == lstUserCount || lstUserCount.size() == 0)
        {
            return null;
        }

        return  lstUserCount.get(0);
    }

}
