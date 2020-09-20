/*
 * 微信公众平台(JAVA) SDK
 *
 * Copyright (c) 2014, Ansitech Network Technology Co.,Ltd All rights reserved.
 * 
 * http://www.weixin4j.org/
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.weixin4j.model.message.event;

import org.weixin4j.model.message.EventType;
import org.weixin4j.model.message.SendLocationInfo;

/**
 * 自定义菜单事件
 *
 * 弹出地理位置选择器的事件推送
 *
 * @author yangqisheng
 * @since 0.0.1
 */
public class LocationSelectEventMessage extends EventMessage {

    //事件KEY值，与自定义菜单接口中KEY值对应
    private String EventKey;
    //发送的位置信息
    private SendLocationInfo SendLocationInfo;

    @Override
    public String getEvent() {
        return EventType.Location_Select.toString();
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String EventKey) {
        this.EventKey = EventKey;
    }

    public SendLocationInfo getSendLocationInfo() {
        return SendLocationInfo;
    }

    public void setSendLocationInfo(SendLocationInfo SendLocationInfo) {
        this.SendLocationInfo = SendLocationInfo;
    }

}
