package by.zubarmikalay.task2.tariff;

import by.zubarmikalay.task2.action.Creator;
import by.zubarmikalay.task2.comparator.TariffComparator;
import by.zubarmikalay.task2.constant.Constant;

import java.util.Collections;
import java.util.List;

/**
 * Created by Nick on 05.10.16.
 */
public class TariffList {
    private List<Tariff> tariffList;

    public TariffList(){
        tariffList = createTariffList();
    }

    public TariffList(List<Tariff> tariffList) {
        this.tariffList = tariffList;
    }

    public List<Tariff> getTariffList() {
        return tariffList;
    }

    public void setTariffList(List<Tariff> tariffList) {
        this.tariffList = tariffList;
    }

    public List<Tariff> createTariffList() {
        List<Tariff> tariffs = Creator.createTarrif(Constant.getRoot());
        return tariffs;
    }

    public void sortTariff(){
        TariffComparator comparator = new TariffComparator();
        Collections.sort(tariffList, comparator);
    }
}
