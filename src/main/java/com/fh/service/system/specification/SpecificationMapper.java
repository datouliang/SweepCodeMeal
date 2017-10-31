package com.fh.service.system.specification;

import com.fh.entity.Page;
import com.fh.util.PageData;

import java.util.List;

/**
 * Created by 大梁
 * Created Time 2017/10/27.
 */
public interface SpecificationMapper {


    /**新增
     * @param pd
     * @throws Exception
     */
    public void save(PageData pd)throws Exception;

    /**删除
     * @param pd
     * @throws Exception
     */
    public void delete(PageData pd)throws Exception;

    /**修改
     * @param pd
     * @throws Exception
     */
    public void edit(PageData pd)throws Exception;

    /**列表
     * @param page
     * @throws Exception
     */
    public List<PageData> list(Page page)throws Exception;

    /**列表(全部)
     * @param pd
     * @throws Exception
     */
    public List<PageData> listAll(PageData pd)throws Exception;

    /**通过id获取数据
     * @param pd
     * @throws Exception
     */
    public PageData findById(PageData pd)throws Exception;

    /**批量删除
     * @param ArrayDATA_IDS
     * @throws Exception
     */
    public void deleteAll(String[] ArrayDATA_IDS)throws Exception;

    /**
     * 根据主表查询所属规格
     * @param pd
     * @return
     * @throws Exception
     */
    public List<PageData> findByFid(PageData pd) throws  Exception;
}
