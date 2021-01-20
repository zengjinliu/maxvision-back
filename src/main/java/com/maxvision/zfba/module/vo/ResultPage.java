package com.maxvision.zfba.module.vo;



import com.maxvision.core.client.module.vo.PagenateInfo;
import com.maxvision.zfba.view.AjaxResult;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

/**
 * @author minte
 * @date 2021/1/15 18:47
 */
public class ResultPage<T> extends AjaxResult<T> {

    private Integer total;


    public static <T> ResultPage<List<T>> page(List<T> list,int count){
        ResultPage<List<T>> resultPage = new ResultPage<>();
        resultPage.setData(list);
        resultPage.setCode(200);
        resultPage.setMsg("success");
        resultPage.setTotal(count);
        return resultPage;
    }

    public static RowBounds bounds(int offSet, int limit){
        PagenateInfo pagenateInfo = new PagenateInfo(offSet,limit);
        RowBounds rb = new RowBounds(pagenateInfo.getOffset(), pagenateInfo.getLimit());
        return rb;
    }


    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
