package com.dimples.ui.main.book.module;

import com.dimples.base.BaseHttpRequest;
import com.dimples.http.request.IRequest;
import com.dimples.http.annotation.RequestMethod;
import com.dimples.ui.main.book.dto.TreatPatientResultBean;

/**
 * @author zhongyj
 * @date 2019/3/27 21:19
 */
public interface BookDetailRequest {

    IRequest REQUEST = BaseHttpRequest.sendHttp("/patient/info/doctor-code", RequestMethod.Get, TreatPatientResultBean.class);

}
