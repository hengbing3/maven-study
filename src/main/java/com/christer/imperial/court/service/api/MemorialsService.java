package com.christer.imperial.court.service.api;

import com.christer.imperial.court.entity.Memorials;

import java.util.List;

/**
 * Description:
 *
 * @author Christer.Hong
 * @version 1.0
 * @date 2022/09/05
 */
public interface MemorialsService {
    List<Memorials> getAllMemorialDigest();
}
