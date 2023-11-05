package org.jaanDeveloper.loading.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "time")
public class TimeBazaar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "load_id")
    private int loadingId;
    @Column(name = "play_no")
    private String loadNum;
    @Column(name = "play_amt")
    private float playAmt;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TimeBazaar= ");
        sb.append("loadNum='").append(loadNum).append('\'');
        sb.append(", playAmt=").append(playAmt);

        return sb.toString();
    }
}
