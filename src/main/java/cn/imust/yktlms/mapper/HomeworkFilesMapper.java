package cn.imust.yktlms.mapper;

import cn.imust.yktlms.entity.HomeworkFiles;
import cn.imust.yktlms.util.MyMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author SERENDIPITY
 */
@Mapper
public interface HomeworkFilesMapper extends MyMapper<HomeworkFiles> {
    List<HomeworkFiles> selectByhomeworkId(String homeworkId);
}
