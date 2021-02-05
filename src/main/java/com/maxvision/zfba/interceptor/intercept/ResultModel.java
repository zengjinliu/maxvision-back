package com.maxvision.zfba.interceptor.intercept;

/**
 * @author minte
 */
public class ResultModel {
    
    /**true成功, false失败*/
    private boolean flag;
    
    /**失败返回的状态码*/
    private int code;

    public static Builder builder(){
        return new Builder();
    }

    public ResultModel(Builder builder) {
        this.flag = builder.flag;
        this.code = builder.code;
    }

    public static class Builder{
        private boolean flag;
        private int code;
        
        public Builder flag(boolean flag){
            this.flag = flag;
            return this;
        }
        public Builder flag(int code){
            this.code = code;
            return this;
        }
        public ResultModel build(){
            return new ResultModel(this);
        }
        
    }
    
    

    public boolean isResultFlag() {
        return flag;
    }

    public void setResultFlag(boolean flag) {
        this.flag = flag;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
