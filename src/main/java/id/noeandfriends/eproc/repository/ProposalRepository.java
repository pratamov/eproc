package id.noeandfriends.eproc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.Proposal;

public interface ProposalRepository extends MongoRepository<Proposal, String>{

	List<Proposal> findByProcurement(Procurement procurement);

}
