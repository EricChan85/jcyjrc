package org.yjrc.models;

import java.util.List;
/**
 *  分页
 * 
 * @author cyh
 *
 * 
 * @param <T>
 * @date 2020年2月21日
 */
public class PagedResult<T> {
	
	public static final long DEFAULT_OFFSET = 0;
	
    public static final int DEFAULT_MAX_NO_OF_ROWS = 100;
    
    //当前页,从1开始
    private int pageIndex;
    
    //每页显示数量
    private int pageSize;
    
    //总数
    private int totalElements;
    
    private List<T> elements;
   
    
    //总页数
    private int pageCount;
    
    public PagedResult(List<T> elements, int totalElements, int pageIndex, int pageSize) {
        this.elements = elements;
        this.totalElements = totalElements;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;    
        this.pageCount = totalElements / pageSize + (totalElements % pageSize > 0 ? 1 : 0);
    }
    
    public boolean hasMore() {
        return totalElements > (pageIndex - 1) * pageSize + pageSize;
    }
    
    public boolean hasPrevious() {
        return (pageIndex - 1) * pageSize > 0 && totalElements > 0;
    }
    
    public int getTotalElements() {
        return totalElements;
    }
    
    public int getPageCount() {    	
    	return this.pageCount;
    }
    
    public int  getOffset() {
        return (pageIndex - 1) * pageSize;
    }
    
    public int getPageIndex() {
    	return pageIndex;
    }
    
    public int getLimit() {
        return pageSize;
    }
    
    public List<T> getElements() {
        return elements;
    }
}
