//snippet-sourcedescription:[S3BucketOps.java demonstrates how to create, list and delete S3 buckets.]
//snippet-keyword:[SDK for Java 2.0]
//snippet-keyword:[Code Sample]
//snippet-service:[s3]
//snippet-sourcetype:[full-example]
//snippet-sourcedate:[2020-02-06]
//snippet-sourceauthor:[scmacdon-aws]
/*
 * Copyright 2011-2020 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.s3;
// snippet-start:[s3.java2.s3_bucket_ops.complete]
// snippet-start:[s3.java2.s3_bucket_ops.import]

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.CreateBucketConfiguration;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.ec2.Ec2Client;
import software.amazon.awssdk.services.ec2.model.DescribeReservedInstancesOfferingsRequest;
import software.amazon.awssdk.services.ec2.model.DescribeReservedInstancesOfferingsResponse;
import software.amazon.awssdk.services.ec2.model.Ec2Exception;
// snippet-end:[s3.java2.s3_bucket_ops.import]
// snippet-start:[s3.java2.s3_bucket_ops.main]
public class FindDiscount{

    public static void main(String[] args) {

        // snippet-start:[s3.java2.s3_bucket_ops.create_bucket]
        // snippet-start:[s3.java2.s3_bucket_ops.region]
       Ec2Client ec2 = Ec2Client.create();
        try {
            DescribeReservedInstancesOfferingsRequest req = DescribeReservedInstancesOfferingsRequest.builder().availabilityZone("us-west-2").instanceType("m5.large").productDescription("Linux/UNIX").build();
            System.out.println(req.toString());
            System.out.println("About to fire off a response");
            DescribeReservedInstancesOfferingsResponse res = ec2.describeReservedInstancesOfferings(req);
            System.out.println(res);
            System.out.println("Recvd a response, printed nothing");
        } catch (Ec2Exception e) {
            e.getStackTrace();
        }
      // snippet-end:[s3.java2.s3_bucket_ops.delete_bucket]
    }
}

// snippet-end:[s3.java2.s3_bucket_ops.main]
// snippet-end:[s3.java2.s3_bucket_ops.complete]
