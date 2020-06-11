package cn.imust.yktlms.mapper;

import cn.imust.yktlms.vo.PagingVO;
import cn.imust.yktlms.entity.Teacher;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface TeacherMapper extends MyMapper<Teacher> {

    /**
     * 分页查询教师信息
     * @param pagingVO
     * @return
     */
    List<Teacher> findByPaging(PagingVO pagingVO);

    int countTeacherNumber();

    List<Teacher> findByTeacherName(String teacherName);

    Teacher selectByTeacherId(String teacherId);
}
