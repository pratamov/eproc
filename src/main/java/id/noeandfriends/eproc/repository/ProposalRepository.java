package id.noeandfriends.eproc.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.Procurement;
import id.noeandfriends.eproc.model.Proposal;
import id.noeandfriends.eproc.model.User;

public interface ProposalRepository extends MongoRepository<Proposal, String>{

	List<Proposal> findByProcurement(Procurement procurement);
	List<Proposal> findByContractor(User contractor);

}
