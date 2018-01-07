package com.ecas.common.shiro.session;

import com.ecas.util.RedisUtil;
import com.ecas.util.SerializationUtil;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by lenovo on 2017/12/28.
 */
public class EcasSessiondDao extends CachingSessionDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(EcasSessiondDao.class);
    private static final String SHIRO_SESSION_ID = "shiro-session-id";

    @Override
    protected void doUpdate(Session session) {
        if (session instanceof ValidatingSession && !((ValidatingSession) session).isValid()) {
            LOGGER.warn("doUpdate, session is isdevalid!");
            return;
        }
        EcasSession ecasSession = (EcasSession) session;
        EcasSession cacheEcasSession = (EcasSession) doReadSession(ecasSession.getId());
        if (cacheEcasSession != null) {
            ecasSession.setStatus(cacheEcasSession.getStatus());
            ecasSession.setAttribute("FORCE_LOGOUT", cacheEcasSession.getAttribute("FORCE_LOGOUT"));
        }

        RedisUtil.set(SHIRO_SESSION_ID + "_" + session.getId(), SerializationUtil.serilaze(session));

        LOGGER.debug("doUpdate, session:{}", session);

    }

    @Override
    protected void doDelete(Session session) {
        LOGGER.debug("doDelete, session:{}", session);
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);
        //TODO cache Session
        LOGGER.debug("doCreate, sessionId:{}", sessionId);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        String sessionStr = RedisUtil.get(SHIRO_SESSION_ID + "_" + sessionId);
        LOGGER.debug("doReadSession, serializable:{}", sessionId);
        return SerializationUtil.deSerilaze(sessionStr);
    }
}
