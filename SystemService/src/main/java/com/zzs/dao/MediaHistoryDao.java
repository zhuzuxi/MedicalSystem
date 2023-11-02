package com.zzs.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzs.entity.Doctor;
import com.zzs.entity.Mediahistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MediaHistoryDao extends BaseMapper<Mediahistory> {
}
