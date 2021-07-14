package com.album.songr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestPostModelRepository extends JpaRepository<TestPostModel , Long> {
}
