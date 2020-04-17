package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.Problem;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface ProblemMapper extends MyMapper<Problem> {
    List<Problem> selectBycourseId(String courseId);
}
