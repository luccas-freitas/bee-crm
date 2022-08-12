package br.com.bee.collect.crmmanager.utils.paging;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PageArray {
    private List<List<String>> data;
    private int recordsFiltered;
    private int recordsTotal;
    private int draw;
}
