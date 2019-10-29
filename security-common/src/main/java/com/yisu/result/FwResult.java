package com.yisu.result;


import com.yisu.constants.FwCommonConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * @author xuyisu
 * @date 2019/9/20
 */
@Data
public class FwResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private Object data;

    //分页信息
    private Object meta;

    public static FwResult ok() {
        return restResult(null, FwCommonConstants.SUCCESS, null, null);
    }

    public static FwResult ok(Object data) {
        return restResult(data, FwCommonConstants.SUCCESS, null, null);
    }

    public static FwResult ok(Object data, String msg) {
        return restResult(data, FwCommonConstants.SUCCESS, msg, null);
    }

    public static FwResult ok(Object data, String msg, Object meta) {
        return restResult(data, FwCommonConstants.SUCCESS, msg, meta);
    }

    public static FwResult failed() {
        return restResult(null, FwCommonConstants.FAIL, null, null);
    }

    public static FwResult failed(String msg) {
        return restResult(null, FwCommonConstants.FAIL, msg, null);
    }

    public static FwResult failed(Object data) {
        return restResult(data, FwCommonConstants.FAIL, null, null);
    }

    public static FwResult failed(Object data, String msg) {
        return restResult(data, FwCommonConstants.FAIL, msg, null);
    }

    private static FwResult restResult(Object data, int code, String msg, Object meta) {
        FwResult fwResult = new FwResult();
        fwResult.setCode(code);
        fwResult.setData(data);
        fwResult.setMsg(msg);
        fwResult.setMeta(meta);
        return fwResult;
    }



}
