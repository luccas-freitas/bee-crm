package br.com.bee.collect.crmmanager.utils.paging;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Order {
    private Integer column;
    private Direction dir;
}
