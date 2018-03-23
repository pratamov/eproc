package id.noeandfriends.eproc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import id.noeandfriends.eproc.model.Proposal;

public interface ProposalRepository extends MongoRepository<Proposal, String>{

}
