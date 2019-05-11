package cn.how2j.grid.dao;
 
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cn.how2j.grid.pojo.Post;
import cn.how2j.grid.pojo.Video;

public interface VideoDAO extends JpaRepository<Video,Integer>{
	Page<Video> findByStatusAndPostOrderByIndexAsc(String status,Post post,Pageable pageable);
}
