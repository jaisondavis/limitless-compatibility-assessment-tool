// Copyright 2024 Amazon.com, Inc. or its affiliates. All Rights Reserved.
// SPDX-License-Identifier: LicenseRef-.amazon.com.-AmznSL-1.0
// Licensed under the Amazon Software License  https://aws.amazon.com/asl/

package com.amazon.limitless.assessment.sql;

import com.amazon.limitless.assessment.configloader.ConfigLoader;
import com.amazon.limitless.assessment.configloader.Feature;
import com.amazon.limitless.assessment.reportgenerator.StatementResult;
import com.amazon.limitless.parser.postgresql.PostgreSQLParser;

import java.util.ArrayList;
import java.util.List;

public class ViewStmtManager extends PostgreSqlStmtBaseManager implements SqlStatementManager<PostgreSQLParser.ViewstmtContext> {

    public ViewStmtManager(ConfigLoader configLoader) {
        super(configLoader);
    }

    @Override
    public List<StatementResult> analyzeStatement(PostgreSQLParser.ViewstmtContext ctx) {
        resultList = new ArrayList<>();
        Feature featureConfig = configLoader.getFeatureConfig("create_view");
        result.setFeature(featureConfig);
        resultList.add(result);
        return resultList;
    }
}
