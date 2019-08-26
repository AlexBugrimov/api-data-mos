package dev.bug.api.data.mos.services.dataSet;

import dev.bug.api.data.mos.exceptions.DataSetAlreadyExistsException;
import dev.bug.api.data.mos.exceptions.DataSetNotExistsException;
import dev.bug.api.data.mos.model.DataSet;
import dev.bug.api.data.mos.repositories.DataSetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataSetServiceRepository implements DataSetService {

    private DataSetRepository dataSetRepository;

    @Autowired
    public DataSetServiceRepository(DataSetRepository dataSetRepository) {
        this.dataSetRepository = dataSetRepository;
    }

    @Override
    public List<DataSet> getAll() {
        return dataSetRepository.findAll();
    }

    @Override
    public DataSet getOneById(Long id) {
        return dataSetRepository
                .findById(id)
                .orElseThrow(DataSetNotExistsException::new);
    }

    @Override
    public DataSet save(DataSet dataSet) {
        final DataSet savedDataSet = dataSet.getDataSetId() == null
                ? dataSet : getExistingDataSet(dataSet.getDataSetId());
        return dataSetRepository.save(savedDataSet);
    }

    @Override
    public DataSet update(Long id, DataSet newDataSet) {
        final DataSet oldDataSet = getExistingDataSet(id);
        BeanUtils.copyProperties(newDataSet, oldDataSet, "dataSetId");
        return dataSetRepository.save(newDataSet);
    }

    @Override
    public void delete(Long id) {
        dataSetRepository.deleteById(getExistingDataSet(id).getDataSetId());
    }

    @Override
    public void clean() {
        dataSetRepository.deleteAll();
    }

    private DataSet getExistingDataSet(Long id) {
        return dataSetRepository.findById(id).orElseThrow(DataSetAlreadyExistsException::new);
    }
}
