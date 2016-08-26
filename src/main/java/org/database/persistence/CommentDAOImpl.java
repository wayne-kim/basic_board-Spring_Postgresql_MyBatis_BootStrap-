package org.database.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.database.domain.CommentVO;
import org.database.domain.Criteria;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl implements CommentDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "org.database.mapper.CommentMapper";
	
	@Override
	public List<CommentVO> list(Integer bno) throws Exception {
		return session.selectList(namespace + ".list", bno);
	}

	@Override
	public void create(CommentVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(CommentVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer cno) throws Exception {
		session.update(namespace + ".delete", cno);
	}

	@Override
	public List<CommentVO> listPage(Integer bno, Criteria cri) throws Exception {
		Map<String, Object> paramMap = new HashMap<>();
		
		paramMap.put("bno", bno);
		paramMap.put("cri", cri);
		return session.selectList(namespace + ".listPage", paramMap);
	}

	@Override
	public int count(Integer bno) throws Exception {
		return session.selectOne(namespace + ".count", bno);
	}

	@Override
	public int getBno(Integer cno) throws Exception {
		return session.selectOne(namespace+".getBno", cno);
	}
}
