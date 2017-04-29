/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.protocol.handler;

import de.rub.nds.tlsattacker.core.protocol.handler.HeartbeatHandler;
import de.rub.nds.tlsattacker.core.protocol.message.HeartbeatMessage;
import de.rub.nds.tlsattacker.core.protocol.parser.HeartbeatMessageParser;
import de.rub.nds.tlsattacker.core.protocol.preparator.HeartbeatMessagePreparator;
import de.rub.nds.tlsattacker.core.protocol.serializer.HeartbeatMessageSerializer;
import de.rub.nds.tlsattacker.core.workflow.TlsContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class HeartbeatHandlerTest {

    private HeartbeatHandler handler;
    private TlsContext context;

    public HeartbeatHandlerTest() {
    }

    @Before
    public void setUp() {
        context = new TlsContext();
        handler = new HeartbeatHandler(context);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getParser method, of class HeartbeatHandler.
     */
    @Test
    public void testGetParser() {
        assertTrue(handler.getParser(new byte[1], 0) instanceof HeartbeatMessageParser);
    }

    /**
     * Test of getPreparator method, of class HeartbeatHandler.
     */
    @Test
    public void testGetPreparator() {
        assertTrue(handler.getPreparator(new HeartbeatMessage()) instanceof HeartbeatMessagePreparator);
    }

    /**
     * Test of getSerializer method, of class HeartbeatHandler.
     */
    @Test
    public void testGetSerializer() {
        assertTrue(handler.getSerializer(new HeartbeatMessage()) instanceof HeartbeatMessageSerializer);
    }

    /**
     * Test of adjustTLSContext method, of class HeartbeatHandler.
     */
    @Test
    public void testAdjustTLSContext() {
        HeartbeatMessage message = new HeartbeatMessage();
        handler.adjustTLSContext(message);
        // TODO check that context did not change
    }

}