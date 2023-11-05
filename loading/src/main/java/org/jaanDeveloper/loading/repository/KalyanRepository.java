package org.jaanDeveloper.loading.repository;

import org.jaanDeveloper.loading.model.KalyanBazaar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface KalyanRepository extends JpaRepository<KalyanBazaar,Integer> {

 @Query(value = "select distinct play_no from kalyan order by play_no ASC",nativeQuery = true)
    List<String> getAllNumbers();

@Query(value = "select sum(play_amt) from kalyan where play_no=:indexOf",nativeQuery = true)
  Long calculateAmount(List<Integer> indexOf);

//Ascending Numbers //
    @Query(value = "select distinct play_no from kalyan order by play_no ASC",nativeQuery = true)
    List<Integer> kalyanGetAscendingAllNumbers();
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num0",nativeQuery = true)
    Long kalyanGetSum0(int num0);
    @Query(value = "select max(play_amt) from kalyan where play_no=:num0",nativeQuery = true)
    long getMaxSum0(int num0);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num1",nativeQuery = true)
    Long kalyanGetSum1(int num1);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num2",nativeQuery = true)
    Long kalyanGetSum2(int num2);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num3",nativeQuery = true)
    Long kalyanGetSum3(int num3);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num4",nativeQuery = true)
    Long kalyanGetSum4(int num4);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num5",nativeQuery = true)
    Long kalyanGetSum5(int num5);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num6",nativeQuery = true)
    Long kalyanGetSum6(int num6);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num7",nativeQuery = true)
    Long kalyanGetSum7(int num7);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num8",nativeQuery = true)
    Long kalyanGetSum8(int num8);
    @Query(value = "select sum(play_amt) from kalyan where play_no=:num9",nativeQuery = true)

    Long kalyanGetSum9(int num9);
    @Query(value = "select min(play_amt) from kalyan where play_no=:num0",nativeQuery = true)
    long getMinSum0(int num0);
   /*
    @Query(value = "select sum(playAmt) from kalyan",nativeQuery = true)
    List<PlayNumber> getSumOfPlayNo();
    */

}
