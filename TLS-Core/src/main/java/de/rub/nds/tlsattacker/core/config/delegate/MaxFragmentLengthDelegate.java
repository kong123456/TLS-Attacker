/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.core.config.delegate;

import com.beust.jcommander.Parameter;
import de.rub.nds.tlsattacker.core.constants.MaxFragmentLength;
import de.rub.nds.tlsattacker.core.workflow.TlsConfig;

/**
 *
 * @author Robert Merget - robert.merget@rub.de
 */
public class MaxFragmentLengthDelegate extends Delegate {

    // TODO Add validator, and extend unit test
    @Parameter(names = "-max_fragment_length", description = "Maximum fragment length definition for the max fragment length TLS extension (possible byte values 1,2,3, or 4)")
    private Integer maxFragmentLength = null;

    public MaxFragmentLengthDelegate() {
    }

    public Integer getMaxFragmentLength() {
        return maxFragmentLength;
    }

    public void setMaxFragmentLength(Integer maxFragmentLength) {
        this.maxFragmentLength = maxFragmentLength;
    }

    @Override
    public void applyDelegate(TlsConfig config) {
        if (maxFragmentLength != null) {
            config.setAddMaxFragmentLengthExtenstion(true);
            config.setMaxFragmentLength(MaxFragmentLength.getMaxFragmentLength(maxFragmentLength.byteValue())); // TODO
        } // Converter
    }
}