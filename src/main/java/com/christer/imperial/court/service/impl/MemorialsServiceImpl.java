package com.christer.imperial.court.service.impl;

import com.christer.imperial.court.dao.api.MemorialsDao;
import com.christer.imperial.court.dao.impl.MemorialsDaoImpl;
import com.christer.imperial.court.entity.Memorials;
import com.christer.imperial.court.service.api.MemorialsService;

import java.util.List;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/05
 */
public class MemorialsServiceImpl  implements MemorialsService {

   private MemorialsDao memorialsDao =  new MemorialsDaoImpl();

   @Override
   public List<Memorials> getAllMemorialDigest() {
      return memorialsDao.selectAllMemorialsDigest();
   }

   @Override
   public Memorials getMemorialsDetailById(String memorialsId) {
      return memorialsDao.selectMemorialsById(memorialsId);
   }

   @Override
   public void updateMemorialsStatusToRead(String memorialsId) {
      memorialsDao.updateMemorialsStatusToRead(memorialsId);
   }

   @Override
   public void updateMemorialsFeedBack(String memorialsId, String feedbackContent) {
      memorialsDao.updateMemorialsFeedBack(memorialsId,feedbackContent);
   }
}
