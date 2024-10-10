package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.session.SqlSession;

import com.app.mybatis.config.MyBatisConfig;
import com.app.vo.PostVO;

public class PostDAO {
	public SqlSession sqlSession;
	
//	객체화(기본생성자 호출)이 될 때 마다
//	SqlSession을 통해 만들어진 SqlSession을 기본생성자에 만들어 놓고 호출될 때 마다 담게한다.
//	openSession()이 SqlSessiondmf return 해주는 메서드이다.
//	SqlSession(autoCommit) : JSP에서는 자동으로 이루어지지만 spring 에서는 트랜젝션이 관리한다.
	// sql 의 최소단위 : 트랜젝션
	
	
	public PostDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}
//	게시글 추가
	public void insert(PostVO postVO) {
		sqlSession.insert("post.insert", postVO);
	}
// 게시글 전체 조회	
	public List<PostVO> selectAll() {
		return sqlSession.selectList("post.selectAll");
	}
//	게시글 상세보기 조회
	public Optional<PostVO> select(Long id) {
		return Optional.ofNullable(sqlSession.selectOne("post.select", id));
	}
// 게시글 삭제
	public void delete(Long id) {
		sqlSession.delete("post.delete", id);
	}
// 게시글 수정
	public void update(PostVO postVO) {
		sqlSession.update("post.update" ,postVO);
	}
}