package com.d30.aquamate.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.d30.aquamate.dao.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, String> {

	
	@Query("SELECT a FROM Activity a WHERE a.activityid = :activityid and a.userid= :userId")
    public Activity getActivityByActivityIdandUserId(@Param("activityid") String activityid,@Param("userId") String userId);

	@Query("SELECT a FROM Activity a WHERE a.userid= :userId")
	public List<Activity> findByUserID(@Param("userId") String userid);

}
