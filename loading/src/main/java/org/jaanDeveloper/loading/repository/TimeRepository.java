package org.jaanDeveloper.loading.repository;

import org.jaanDeveloper.loading.model.TimeBazaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@EnableJpaRepositories
@Repository
public interface TimeRepository extends JpaRepository<TimeBazaar,Integer> {
    @Query(value = "select distinct play_no from time order by play_no asc",nativeQuery = true)
    List<Integer> getAllNumbers();

    @Query(value = "select sum(play_amt) from time where play_no=:indexOf",nativeQuery = true)
    Long calculateAmount(List<Integer> indexOf);

    // time Ascending //

    @Query(value = "select distinct play_no from time order by play_no ASC",nativeQuery = true)
    List<Integer> timeGetAscendingAllNumbers();
    @Query(value = "select sum(play_amt) from time where play_no=:num0",nativeQuery = true)
    Long timeGetSum0(int num0);
    @Query(value = "select sum(play_amt) from time where play_no=:num1",nativeQuery = true)
    Long timeGetSum1(int num1);
    @Query(value = "select sum(play_amt) from time where play_no=:num2",nativeQuery = true)
    Long timeGetSum2(int num2);
    @Query(value = "select sum(play_amt) from time where play_no=:num3",nativeQuery = true)
    Long timeGetSum3(int num3);
    @Query(value = "select sum(play_amt) from time where play_no=:num4",nativeQuery = true)
    Long timeGetSum4(int num4);
    @Query(value = "select sum(play_amt) from time where play_no=:num5",nativeQuery = true)
    Long timeGetSum5(int num5);
    @Query(value = "select sum(play_amt) from time where play_no=:num6",nativeQuery = true)
    Long timeGetSum6(int num6);
    @Query(value = "select sum(play_amt) from time where play_no=:num7",nativeQuery = true)
    Long timeGetSum7(int num7);
    @Query(value = "select sum(play_amt) from time where play_no=:num8",nativeQuery = true)
    Long timeGetSum8(int num8);
    @Query(value = "select sum(play_amt) from time where play_no=:num9",nativeQuery = true)
    Long timeGetSum9(int num9);

   /*
    @Query(value = "select sum(playAmt) from time",nativeQuery = true)
    List<PlayNumber> getSumOfPlayNo();
    */
}
