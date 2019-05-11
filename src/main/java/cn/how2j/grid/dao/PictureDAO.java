package cn.how2j.grid.dao;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.how2j.grid.pojo.Picture;
import cn.how2j.grid.pojo.Post;

public interface PictureDAO extends JpaRepository<Picture,Integer>{
	Page<Picture> findByStatusAndPostOrderByIndexAsc(String status,Post post,Pageable pageable);
}
