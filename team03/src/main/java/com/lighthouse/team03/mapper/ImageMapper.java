package com.lighthouse.team03.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;



@Mapper
public interface ImageMapper {
	
	@Insert("insert into image values (#{img}")
	public void saveImage1(@Param("img") byte[] img);
	
	@Select("SELECT * FROM users WHERE username = #{userName}")
    public List<byte[]> getAllImages1();

	public void saveImage(byte[] img);

	public List<byte[]> getAllImages();
}




