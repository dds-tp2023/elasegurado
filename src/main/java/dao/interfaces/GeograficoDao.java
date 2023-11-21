package dao.interfaces;

import java.util.List;
import dto.ProvinciaDTO;

public interface GeograficoDao {
	public List<ProvinciaDTO> getAllProvinciasConLocalidades();
}