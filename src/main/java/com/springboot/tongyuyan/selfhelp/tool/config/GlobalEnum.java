package com.springboot.tongyuyan.selfhelp.tool.config;

/**
 *
 * @作者 :赵超林
 * @创建时间： 2018年3月14日
 * @类说明:全局状态码枚举
 * @类名称:GlobalEnum
 */
public interface GlobalEnum {
    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:正确响应枚举，0-1
     * @类名称:GlobalSucceedEnum
     */
     enum GlobalSucceedEnum implements GlobalEnum {

        // 响应成功类型
        /**
         * 响应成功 0
         */
        SUCCEED(0),

        /**
         * 正在进行分片上传 1
         */
        CHUNK_UP(1),

        /**
         * 逻辑取反成功 1
         */
        LOGIC_INVERSE(1),

        /**
         * 未绑定手机1，主要针对第三方用户登陆时，app端接收判断并跳转；
         */
        NOT_BIND_MOBILE(1),

        ;
        private Integer code;

        private GlobalSucceedEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }

    enum GlobalFailedEnum implements GlobalEnum {

        // 响应失败类型
        /**
         * 响应失败 -1
         */
        FAILED(-1),
        ;
        private Integer code;

        private GlobalFailedEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }

    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:值验证，100-199
     * @类名称:GlobalValueVerifyEnum
     */
     enum GlobalValueVerifyEnum implements GlobalEnum {

        /**
         * token没有传入 100
         */
        TOKEN_IS_NULL(100),

        /**
         * token解析异常 101
         */
        TOKEN_IS_EXCEPTION(101),

        /**
         * token过期 102
         */
        TOKEN_OUT_OF_DATE(102),

        /**
         * 参数为空 103
         */
        PARAM_IS_NULL(103),

        /**
         * 值超出合法范围 104
         */
        VALUE_OUT_OF_RANGE(104),

        ;
        private Integer code;

        private GlobalValueVerifyEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }

    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:格式错误 200-299
     * @类名称:GlobalFormatEnum
     */
     enum GlobalFormatEnum implements GlobalEnum {

        /**
         * 格式错误 200
         */
        FORMAT_FAILED(200), ;
        private Integer code;

        private GlobalFormatEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }


    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:数据库操作枚举,300-399
     * @类名称:GlobalDataBaseEnum
     */
     enum GlobalDataBaseEnum implements GlobalEnum{


        /**
         * 数据库操作失败 300
         */
        DATABASE_FAILED(300),

        /**
         * 冻结不可用 301
         */
        FREEZE(301),

        ;
        private Integer code;

        private GlobalDataBaseEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }

    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:IO状态 400-499
     * @类名称:GlobalFormatEnum
     */
     enum GlobalIOEnum implements GlobalEnum{


        /**
         * 上传资源失败 400
         */
        UPLOAD_FAILED(400),

        /**
         * 资源操作失败 401
         */
        RESOURCE_PERATIONS_FAILED(401),

        /**
         * 资源不可用 402
         */
        RESOURCE_NOT_APPLICABLE(402),

        /**
         * 文件读取异常 403
         */
        FILE_READ_EXCEPTION(403),
        ;
        private Integer code;

        private GlobalIOEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }


    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:权限状态枚举 500-599
     * @类名称:GlobalAuthorityEnum
     */
    enum GlobalAuthorityEnum implements GlobalEnum {

        /**
         * 权限不够 500
         */
        PERMISSION_DENIED(500),

        /**
         * 验证失败 501
         */
        AUTH_FAILED(501),

        ;
        private Integer code;

        private GlobalAuthorityEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }


    /**
     *
     * @作者 :严祥
     * @创建时间： 2016年8月15日
     * @类说明:其他异常 1000以后
     * @类名称:GlobalFormatEnum
     */
     enum GlobalOtherEnum implements GlobalEnum {

        /**
         * 失败 1000
         */
        GLOBAL_FAILED(1000),

        /**
         * 服务器异常 2000
         */
        GLOBAL_EXCEPTION(2000)

        ;
        private Integer code;

        private GlobalOtherEnum(Integer code) {
            this.code = code;
        }

        public Integer getCode() {
            return code;
        }

        public void setcode(Integer code) {
            this.code = code;
        }

    }


}
