package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.Homework;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface HomeworkMapper extends MyMapper<Homework> {

    List<Homework> selectBycourseId(String courseId);
}
