provider "aws" {
  profile = "${var.profile}"
  shared_credentials_file = "~/.aws/credentials"
  region = "${var.aws_region}"
}

resource "aws_security_group" "instance" {
  name = "terraform_example_instance2"

  # HHTP access from anywhere
  ingress {
    from_port = 80
    to_port = 81
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # HHTP access from anywhere
  ingress {
    from_port = 5666
    to_port = 5666
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }
  #MYSQL ACCESS
  ingress {
    from_port = 3306
    to_port = 3306
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }


  # SSH access from anywhere
  ingress {
    from_port = 22
    to_port = 22
    protocol = "tcp"
    cidr_blocks = ["0.0.0.0/0"]
  }

  # Outbound internet access
  egress {
    from_port = 0
    to_port = 0
    protocol = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }
}

resource "aws_rds_cluster" "default" {
  cluster_identifier      = "aurora-cluster-demo"
  engine                  = "aurora-mysql"
  availability_zones      = ["us-west-2a", "us-west-2b", "us-west-2c", "eu-north-1"]
  database_name           = "mydb"
  master_username         = "foo"
  master_password         = "bar"
  backup_retention_period = 5
  preferred_backup_window = "07:00-09:00"
}

resource "aws_elastic_beanstalk_application" "pityu-jenkins" {
  name        = "pityu-jenkins"
  description = "tf-test-desc"
}


