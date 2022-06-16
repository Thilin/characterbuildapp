package com.example.characterbuilderapp.core.business.visioncard;

import com.example.characterbuilderapp.core.operations.visioncard.VisionCardOperation;

public interface VisionCardCommand {

    VisionCardOperation execute(VisionCardOperation operation);
}
