package com.hccake.ballcat.commom.log.error.service;

/**
 * @author Hccake
 * @version 1.0
 * @date 2019/10/18 17:05
 * 异常日志处理类
 */
public interface ErrorLogHandlerService {

    /**
     * 在此处理错误信息
     * 进行落库，入ES， 发送报警通知等信息
     * @param throwable
     */
    void handle(Throwable throwable);

}
